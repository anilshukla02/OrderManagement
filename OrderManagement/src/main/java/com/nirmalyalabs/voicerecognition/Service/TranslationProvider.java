package com.nirmalyalabs.voicerecognition.Service;

import org.springframework.lang.Nullable;

import lombok.NonNull;

public interface TranslationProvider {

	  /**
     * Get a translated version of a text.
     *
     * @param original  The original text that is supposed to be translated
     * @param fromLang  Source text language code
     * @param toLang    Result text language code
     * @return The translated text
     */
    @Nullable
    String getTranslation(@NonNull String original, @NonNull  String fromLang, @NonNull  String toLang);

    /**
     * Check if the provider is working correctly.
     *
     * @return {@code true} in case the provider is properly working
     */
    boolean isProviderWorking();
}
