import org.nazt.lexto.*
import groovy.util.*
import java.*
import groovy.util.*

class JavaController {
	def myTypeList,myIndexList=[]
    def index = { 
		println System.getProperty("user.dir");
		def lexdict=new File("lexitron.txt")
	
		lexdict.eachLine{ servletContext.tokenizer.addDict(it.trim()) }
		def news=new File("news.txt")
		news.eachLine{ line ->
			servletContext.tokenizer.wordInstance(line.trim())
			myTypeList = servletContext.tokenizer.getTypeList()
			myIndexList=servletContext.tokenizer.getIndexList()
		
			def indexer=0
			def longlexnews=""
			myIndexList.eachWithIndex{ val, idx ->
				longlexnews+= line[indexer..val-1] + "|" 
				indexer=val
			}
			//new News(news:line,lexnews:longlexnews,corrected:false).save()
 
			render longlexnews + "nat2<br>\n"
		
		
				
		}
	


	println myIndexList
	println myTypeList
 

	 } 
}
/*/	

	println System.getProperty("user.dir");
	
	System.setProperty( "file.encoding", "UTF-8" );*/
/*System.out.println("Encoding: " + System.getProperty("file.encoding"));
System.out.println("Charset: " + java.nio.charset.Charset.defaultCharset());

 System.out.println("Encoding: " + System.getProperty("file.encoding"));
System.out.println("Charset: " + java.nio.charset.Charset.defaultCharset());
*/