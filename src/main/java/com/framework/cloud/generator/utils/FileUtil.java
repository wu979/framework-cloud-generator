package com.framework.cloud.generator.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.io.File;

/**
 * 文件工具
 *
 * @author wusiwei
 */
public class FileUtil {


    /**
     * 判断文件是否存在
     *
     * @param path 路径
     */
    public static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
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
