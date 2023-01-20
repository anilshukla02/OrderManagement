function init() {
	window.SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
	if (('SpeechRecognition' in window || 'webkitSpeechRecognition' in window)) {
	//	if (typeof speech == 'undefined') {
			let speech = {
				enabled: true,
				listening: false,
				recognition: new window.SpeechRecognition(),
				text: ''
			}
			speech.recognition.continuous = true;
			speech.recognition.interimResults = true;


			//		/*<![CDATA[*/
			//		// var preflang1 = /*[[${session.SPRING_SECURITY_CONTEXT.authentication.principal.preflang}]]*/ 'en-IN';
			//		var preflang = /*[[${#authentication.getPrincipal().preflang}]] */ 'en-IN';
			//		/*]]>*/

			speech.recognition.lang = localStorage.getItem('userLang');
	//	}
		speech.recognition.addEventListener('result', (event) => {
			const audio = event.results[event.results.length - 1];
			speech.text = audio[0].transcript;
			const tag = document.activeElement.nodeName;
			if (tag === 'INPUT' || tag === 'TEXTAREA'  ) {
				if (audio.isFinal) {
					var String1 = speech.text;
					var String2 = String1.trim();
					document.activeElement.value += String2;
				}
			}
			result.innerText = speech.text;
		});

		toggle.addEventListener('click', () => {
			speech.listening = !speech.listening;
			if (speech.listening) {
				toggle.classList.add('listening');
				toggle.innerText = 'Listening. Click field and talk ...';
			//	document.getElementById("itemid").focus();
				speech.recognition.start();
			}
			else {
				toggle.classList.remove('listening');
				toggle.innerText = 'Toggle listening';
				speech.recognition.stop();
			}
		})
	}
}
window.addEventListener('load', init);