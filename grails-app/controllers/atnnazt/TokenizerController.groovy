package atnnazt

import org.nazt.lexto.*
import groovy.util.*
import java.*
import grails.converters.*

class TokenizerController {

    def index = {
      def lexdict=new File("lexitron.txt")
      lexdict.eachLine{ servletContext.tokenizer.addDict(it.trim()) }
      def line = params.word
      servletContext.tokenizer.wordInstance(line)
      def myTypeList = servletContext.tokenizer.getTypeList()
      def myIndexList= servletContext.tokenizer.getIndexList()
      servletContext.tokenizer.getIndexList()
      println params
      def indexer=0
      def tokenized_string="|"
      def outputList = []
      myIndexList.eachWithIndex{ val, idx ->
        tokenized_string += line[indexer..val-1] + "|"
        outputList << line[indexer..val-1]
        indexer=val
      }
      def data =['text': tokenized_string, 'list': outputList]

      if (params.callback)
      {
        render (
           text: "${params.callback}(${data as JSON})",
           contentType: "text/javascript",
           encoding: "UTF-8"
         )
      } else {
         render data as JSON
      }


   }
}
