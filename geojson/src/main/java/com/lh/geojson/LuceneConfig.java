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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;

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
    String indexFilePath;

    private Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);
    private IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_40, analyzer);


    private FSDirectory directory;
    private IndexWriter indexWriter;
    private IndexReader indexReader;

    public LuceneConfig() {

    }

    @PostConstruct
    void init() {
        try {
            File file = new File(indexFilePath);
            if (file.exists()) {
                file.delete();
            }
            directory = FSDirectory.open(file);
            this.indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            if (this.getIndexWriter() == null) {
                this.indexWriter = new IndexWriter(directory, indexWriterConfig);
            }
        } catch (IOException ex) {

        }
    }


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
        return this.indexWriter;
    }

    public void setIndexWriter(IndexWriter indexWriter) {
        this.indexWriter = indexWriter;
    }

    public IndexReader getIndexReader() throws IOException {
        if (indexReader == null) {
            indexReader = DirectoryReader.open(this.directory);
        }
        return indexReader;
    }

    public void setIndexReader(IndexReader indexReader) {
        this.indexReader = indexReader;
    }
}
