package com.zqy.ms.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zqy.ms.user.entity.SysDict;
import com.zqy.ms.user.mapper.SysDictMapper;
import com.zqy.ms.user.service.SysDictService;
import org.springframework.stereotype.Service;

/**
 * 字典表,测试表
 *
 * @author Alan
 * @date 2019-08-01 10:54:19
 */
@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

}
