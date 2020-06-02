package com.example.demo.service.impl;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.pojo.BaseResponse;
import com.example.demo.pojo.StatusCodeDesc;
import com.example.demo.pojo.entity.Admin;
import com.example.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @program: demo
 * @className: AdminServiceImpl
 * @description: admin service impl
 * @author: lov.moran
 * @date 2020/5/30 下午2:43
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public BaseResponse registered(Admin admin) {
        BaseResponse baseResponse = null;
        try {
            Admin existAdmin = adminMapper.getByName(admin.getName());
            if (existAdmin != null) {
                baseResponse = new BaseResponse(201, "用户名已存在");
                return baseResponse;
            }
            adminMapper.insert(admin);
            baseResponse = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(), "注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return baseResponse;
    }

    @Override
    public BaseResponse login(Admin admin) {
        BaseResponse baseResponse = null;
        try {
            Admin existingAdmin = adminMapper.getByName(admin.getName());
            if (existingAdmin == null) {
                baseResponse = new BaseResponse(StatusCodeDesc.ACCOUNT_NOT_EXISTS.getCode(),
                        StatusCodeDesc.ACCOUNT_NOT_EXISTS.getDesc());
            } else {
                if (!decryptBasedDes(existingAdmin.getPassword()).equals(admin.getPassword())) {
                    baseResponse = new BaseResponse(StatusCodeDesc.LOGIN_FAIL_WRONG_INFORMATION.getCode(),
                            StatusCodeDesc.LOGIN_FAIL_WRONG_INFORMATION.getDesc());
                } else {
                    baseResponse = new BaseResponse(StatusCodeDesc.SUCCESS.getCode(), "登陆成功");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse(StatusCodeDesc.INTERNAL_SERVER_ERROR.getCode(),
                    StatusCodeDesc.INTERNAL_SERVER_ERROR.getDesc());
        }
        return baseResponse;
    }

    /**
     * EDS的加密解密代码
     */
    private static final byte[] DES_KEY = {21, 1, -110, 82, -32, -85, -128, -65};

    @SuppressWarnings("restriction")
    public static String encryptBasedDes(String data) {
        String encryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            // log.error("加密错误，错误信息：", e);
            throw new RuntimeException("加密错误，错误信息：", e);
        }
        return encryptedData;
    }

    @SuppressWarnings("restriction")
    public static String decryptBasedDes(String cryptData) {
        String decryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串进行解码，解码为为字节数组，并解密
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            throw new RuntimeException("解密错误，错误信息：", e);
        }
        return decryptedData;
    }

}
