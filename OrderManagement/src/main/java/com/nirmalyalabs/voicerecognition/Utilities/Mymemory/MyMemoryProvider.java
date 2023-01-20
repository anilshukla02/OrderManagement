package com.nirmalyalabs.voicerecognition.Utilities.Mymemory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nirmalyalabs.voicerecognition.Service.TranslationProvider;

import lombok.NonNull;

@Service
public class MyMemoryProvider implements TranslationProvider {

	@NonNull
	private static final Logger log = LoggerFactory.getLogger(MyMemoryProvider.class);

	@Nullable
	private final URL serviceUrl;

	private boolean operational;

	public MyMemoryProvider() {
		URL url = null;
		try {
			url = new URL("http://api.mymemory.translated.net/get");
		} catch (MalformedURLException e) {
			log.error("Failed to resolve the URL to the translator service. Service is not active.", e);
		}
		serviceUrl = url;
		operational = true;
	}

	@Nullable
	@Override
	public String getTranslation(@NonNull String original, @NonNull String fromLang, @NonNull String toLang) {
		String LangPair = fromLang + "|" + toLang;
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(serviceUrl).append('?');
		
		try {
			queryBuilder.append("q=").append(URLEncoder.encode(original, "UTF-8"));
			queryBuilder.append('&').append("langpair=").append(URLEncoder.encode(LangPair, "UTF-8"));
			
			queryBuilder.append('&').append("of=json");
			queryBuilder.append('&').append("de=").append(URLEncoder.encode("anilshukla02@gmail.com", "UTF-8"));

			URL queryUrl = new URL(queryBuilder.toString());
	        // getting URI from url  
            URI queryUri = queryUrl.toURI();  
            
    		HttpClient client = HttpClient.newBuilder()
    				.version(Version.HTTP_2)
    				.followRedirects(Redirect.ALWAYS)
    				.build();
    		
    		HttpRequest request = HttpRequest.newBuilder()
    				.uri(queryUri)
    				.GET()
    				.timeout(Duration.ofSeconds(10))
    				.build();

    		/*
    				client.sendAsync(request, BodyHandlers.ofString())
    						.thenApply(HttpResponse::body)
    						.thenAccept(System.out::println)
    						.join();
    		*/
    		CompletableFuture<HttpResponse<String>> asyncResponse = null;
    		asyncResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
    		
            String asyncResultBody = null;
            int asyncResultStatusCode = 0;

            try {
            	ObjectMapper mapper = new ObjectMapper();  
            	asyncResultBody = asyncResponse.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
            	Response response = mapper.readValue(asyncResultBody, Response.class); 
            	// Response response = objectMapper.readValue(response.getEntity().getContent(), MyObject.class);
            	asyncResultStatusCode = asyncResponse.thenApply(HttpResponse::statusCode).get(5, TimeUnit.SECONDS);
        		//System.out.println("Code:"+asyncResultStatusCode);
            	return(response.getResponseData().getTranslatedText());
            
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } catch (JsonParseException e) {  
                e.printStackTrace();  
            }catch (JsonMappingException e) {  
                e.printStackTrace();   
            }catch (IOException e) {  
                e.printStackTrace();   
            }  
	
    		
		} catch (UnsupportedEncodingException e) {
			log.error("Error while encoding the text for transfer to the MyMemory provider.", e);
		} catch (MalformedURLException e) {
			log.error("Generated URL for the query to MyMemory appears to have a invalid format.", e);
		} catch (URISyntaxException e) {  
            System.out.println("URI Syntax Error: " + e.getMessage());  
      }  


		// The provider is not working anymore. That either happens because the provider
		// is unreachable or because
		// the provider is not accepting any more requests. Either way to reduce
		// overhead the provider may shut down for
		// this session to reduce the overhead.
		operational = false;
		return null;
	}

	@Override
	public boolean isProviderWorking() {
		return (serviceUrl != null) && operational;
	}

}
