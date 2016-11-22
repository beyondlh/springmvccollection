package com.lh.geojson;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by lh on 2016/11/18.
 */
public class LuceneConfigTest extends SpringTestUtil {

    @Autowired
    AppConfig appConfig;

    @Test
    public void test() throws IOException {
        int hitPerPage = 10;
        String queryStr = "昌北小学";
        IndexReader indexReader = appConfig.luceneConfig.getIndexReader();
        Query query = null;
        try {
            query = new QueryParser(Version.LUCENE_40, "NAME", appConfig.luceneConfig.getAnalyzer()).parse(queryStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        TopScoreDocCollector topScoreDocCollector = TopScoreDocCollector.create(hitPerPage, true);
        indexSearcher.search(query,topScoreDocCollector);

        ScoreDoc[] scoreDocs = topScoreDocCollector.topDocs().scoreDocs;

        for(ScoreDoc scoreDoc:scoreDocs){
            int docID = scoreDoc.doc;
            Document document = indexSearcher.doc(docID);
            System.out.println(document.get("NAME") + "\t"+ document.get("ADDRESS"));
        }

    }
}