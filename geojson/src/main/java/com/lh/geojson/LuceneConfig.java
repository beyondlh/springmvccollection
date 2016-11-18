package com.lh.geojson;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;

/**
 * Created by lh on 2016/11/18.
 */
@Component
public class LuceneConfig {

    @Value("${shape.dir}")
    private String indexFilePath;


    private Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
    private IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_40, analyzer);

    public String getIndexFilePath() {
        return indexFilePath;
    }

    public void setIndexFilePath(String indexFilePath) {
        this.indexFilePath = indexFilePath;
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }


    public IndexWriterConfig getIndexWriterConfig() {
        return indexWriterConfig;
    }

    public void setIndexWriterConfig(IndexWriterConfig indexWriterConfig) {
        this.indexWriterConfig = indexWriterConfig;
    }

    public IndexWriter getIndexWriter() {
        return indexWriter;
    }

    public void setIndexWriter(IndexWriter indexWriter) {
        this.indexWriter = indexWriter;
    }

    public IndexReader getIndexReader() {
        return indexReader;
    }

    public void setIndexReader(IndexReader indexReader) {
        this.indexReader = indexReader;
    }

    public IndexSearcher getIndexSearcher() {
        return indexSearcher;
    }

    public void setIndexSearcher(IndexSearcher indexSearcher) {
        this.indexSearcher = indexSearcher;
    }

//    public static LuceneConfig getLuceneConfig() {
//        return luceneConfig;
//    }

//    public static void setLuceneConfig(LuceneConfig luceneConfig) {
//        LuceneConfig.luceneConfig = luceneConfig;
//    }

    private IndexWriter indexWriter;
    private IndexReader indexReader;
    private IndexSearcher indexSearcher;


//    private static LuceneConfig luceneConfig = new LuceneConfig();

/*    public static LuceneConfig getInstance() {
        return luceneConfig;
    }*/

    public LuceneConfig() {
        System.out.println("构造函数");
        System.out.println("this.getIndexFilePath():" + this.getIndexFilePath());
    }

    @PostConstruct
    void init() {
        System.out.println("postconstruct");
        System.out.println("this.getIndexFilePath():" + this.getIndexFilePath());
          try {

            FSDirectory directory = FSDirectory.open(new File(this.indexFilePath + "\\index"));
            indexReader = DirectoryReader.open(directory);
            indexSearcher = new IndexSearcher(indexReader);
            indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            indexWriter = new IndexWriter(directory, indexWriterConfig);
        } catch (IOException ex) {

        }
    }
}
