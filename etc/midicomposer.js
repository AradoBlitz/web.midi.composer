

casper.test.begin('get midicomposer page', function(test){
	casper.start('http://localhost:8080/web.midi.composer/#',function(){
			test.assertHttpStatus(200);
	}).run(function(){
		test.done();
	});
	
});

casper.test.begin("Page should code table and note sheet.", function(test){
	casper.start('http://localhost:8080/web.midi.composer/#', function(){
		test.assertExists('#notepanel');
		test.assertExists('#note-sheet');
		test.assertExists('#compile');
		test.assertSelectorHasText('a','Play hinematov.mid');
	}).run(function(){
		test.done();
	});
});
