# XPATH
##XPath Expression #1 
doc("j_caesar.xml")//(ACT,PERSONAE)/TITLE 
##XPath Expression #2
doc("j_caesar.xml")//ACT[./TITLE]/*/SPEECH/../TITLE 
##XPath Expression #3
doc("j_caesar.xml")//ACT[./TITLE]/*/SPEECH/../*/.././TITLE 
##XPath Expression #4
doc("j_caesar.xml")//ACT[(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE
##XPath Expression #5
doc("j_caesar.xml")//ACT[not(./TITLE)==(./TITLE)]/*/SPEECH/../TITLE

##XPath Expression #6 for text()
doc("j_caesar.xml")//(ACT,PERSONAE)/TITLE/text()

#XPath Expression #7 for parents of text()
doc("j_caesar.xml")//(ACT,PERSONAE)/TITLE/text()/..

##XPath Expression #7 for attr
doc("j_caesar_attr.xml")//(ACT,PLAY)/TITLE/@date

##XPath Expression #7 for attr's parent
doc("j_caesar_attr.xml")//(ACT,PLAY)/TITLE/@date/..

##XPath Expression #8 for parents null
doc("j_caesar.xml")/PLAY/../../..


#XQuery
null string will miss the first tag, why?



