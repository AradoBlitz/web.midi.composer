

casper.test.begin('get midicomposer page', function(test){
	casper.start('http://localhost:8080/web.midi.composer/#',function(){
			test.assertHttpStatus(200);
	}).run(function(){
		test.done();
	});
	
});
