const speak = (text = "") => {
	var msg = new SpeechSynthesisUtterance(text);
	msg.voice = window.speechSynthesis.getVoices()[3];
	msg.voiceURI = 'native';
	//    msg.lang = 'en-US';
	msg.lang = 'hi-IN';
	window.speechSynthesis.speak(msg);
}

// need to call this once to load the voices before hand
window.speechSynthesis.getVoices();