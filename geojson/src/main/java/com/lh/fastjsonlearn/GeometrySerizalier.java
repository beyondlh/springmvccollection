package com.lh.fastjsonlearn;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by lh on 2016/11/15.
 */
public class GeometrySerizalier implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (fieldName != "the_geo") {
            String name = (String) object;
            jsonSerializer.write(name);
        }
    }
}
