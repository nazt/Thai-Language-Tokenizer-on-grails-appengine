import org.nazt.lexto.*
class BootStrap {

     def init = { servletContext ->
		servletContext.tokenizer=new LongLexTo("SELFED DICT") 
     }
     def destroy = {
     }
} 