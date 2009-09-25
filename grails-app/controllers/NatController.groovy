import helloworld.*
import org.nazt.lexto.*
import groovy.util.*
import java.*
import groovy.util.*
class NatController {

    def index = { 	def myTypeList,myIndexList=[]
	def line="แมวตดจะเหม็นไหม";	servletContext.tokenizer.wordInstance(line.trim())
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
}
