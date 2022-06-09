package com.framework.cloud.generator.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件工具
 *
 * @author wusiwei
 */
public class FileUtil {

    /**
     * 判断文件是否存在
     *
     * @param fileName 路径
     * @param level 层级
     */
    public static boolean checkDir(String fileName, Integer level) {
        try {
            Path path = Paths.get(fileName);
            if (Files.exists(path)) {
                return true;
            }
            if (Files.exists(path.getParent())){
                if (level == 0){
                    Files.createFile(path);
                }else {
                    Files.createDirectory(path);
                }
            }else {
                checkDir(path.getParent().toString(), level + 1);
                checkDir(fileName, level);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 路径替换
     *
     * @param projectPath 项目地址
     * @param packagePath 包地址
     */
    public static String replacePath(String projectPath, String packagePath) {
        String path = projectPath + packagePath;

        return path.replaceAll(StringPool.BACK_SLASH + StringPool.DOT, StringPool.BACK_SLASH + File.separator);
    }
}
