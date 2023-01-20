function speak(text = "")  {

   // translate(text,localStorage.getItem('userLang'));
   
    if(!text) return;

	var utterance = new SpeechSynthesisUtterance(text);
	var lang = localStorage.getItem('userLang');
	utterance.lang = lang;
	utterance.voiceURI = 'native';

	window.speechSynthesis.speak(utterance);
}

// need to call this once to load the voices before hand
window.speechSynthesis.getVoices();