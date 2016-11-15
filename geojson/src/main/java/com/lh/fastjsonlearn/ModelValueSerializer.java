package com.lh.fastjsonlearn;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by lh on 2016/11/15.
 */
public class ModelValueSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        String name = (String) object;
        name = name + "先生";
        jsonSerializer.write(name);
    }
}
