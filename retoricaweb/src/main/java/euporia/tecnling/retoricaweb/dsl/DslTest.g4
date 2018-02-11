grammar DslTest;

taggedSentence: tag+;
tag: (mf|sml|anf)(endmf|endsml|endanf);
mf: '<mf>'SENTENCE;
sml: '<sml>'(SENTENCE|firstTerm)firstTerm?(SENTENCE|secondTerm)secondTerm?SENTENCE?;
firstTerm: '#1'SENTENCE;
secondTerm: '#2'SENTENCE;
anf: '<anf>'SENTENCE;
endmf: '</mf>';
endsml: '</sml>';
endanf: '</anf>';
SENTENCE: [A-Za-z.,; \t\n\r(){}"']+;
WORDS: [A-Za-z ]+;

