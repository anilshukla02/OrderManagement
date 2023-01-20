async function translateMessage(text = "", translateFrom = "", translateTo = "", fldname = "") {

	if ((!text || !translateFrom || !translateTo || !fldname) || (translateFrom === translateTo))
		return;

	let apiUrl = `https://api.mymemory.translated.net/get?q=${text}&langpair=${translateFrom}|${translateTo}`;
	let myText = "";
	fetch(apiUrl)
		.then(res => res.json())
		.then(data => {
			myText = data.responseData.translatedText;
			document.getElementById(fldname).innerHTML = myText;
			data.matches.forEach(data => {
				if (data.id === 0) {
					myText = data.translation;
					text = data.translation;
					document.getElementById(fldname).innerHTML = myText;
					speak(myText);
				}
			});
		});

}



