package com.sanelee.springbootneo4jschool.config;

import com.sanelee.springbootneo4jschool.utils.CustomDictWordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.activation.CommandObject;
import java.io.*;

/**
 * @author sanelee
 * @date 2020/6/3
 **/
@Component
public class ConfigRunner implements CommandLineRunner {
    @Value("${HanLP.CustomDictionary.cache.path}")
    private String cacheDictPath;

    @Value("${HanLP.CustomDictionary.path.schoolDict}")
    private String schoolDictPath;

    @Value("${HanLP.CustomDictionary.path.professionDict}")
    private String professionDictPath;

    @Override
    public void run(String... args) throws Exception {
        //先删除缓存
        File file = new File(cacheDictPath);
        if(file.exists()){
            file.delete();
            System.out.println("CustomDictionary.txt.bin delete success .");
        }

        /**加载自定义的【学校】字典 == 设置词性 ntu 0*/
        loadDict(schoolDictPath,0);
        /**加载自定义的【专业】字典 == 设置词性 pr 0*/
        loadDict(professionDictPath,1);
    }
    /**
     * 加载自定义词性字典
     * @param path 字典路径
     * @param type 类型
     */
    public void loadDict(String path,Integer type) {
        File file = new File(path);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            addCustomDictionary(br, type);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 添加自定义分词及其词性，注意数字0表示频率，不能没有
     *
     * @param br 字节流（读）
     * @param type 字典类型
     */
    public void addCustomDictionary(BufferedReader br, int type) {

        String word;
        try {
            while ((word = br.readLine()) != null) {
                switch (type) {
                    /**设置学校名词词性词 词性 == ntu 0*/
                    case 0:
                        CustomDictWordUtils.setNatureAndFrequency(word,"ntu 0",true);
                        break;
                    /**设置专业名词词性词 词性 == pr 0*/
                    case 1:
                        CustomDictWordUtils.setNatureAndFrequency(word,"pr 0",true);
                        break;
                    default:
                        break;
                }
            }
            br.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
