package com.ft.test003;

import org.springframework.stereotype.Service;

/**
 * @author mask
 * @date 2018/2/7 11:25
 * @desc
 */
@Service("typeCTask")
public class TypeCTask {
    public void reloadConfig(){
        System.out.println("TypeCTask-重新加载配置文件");
    }
}
