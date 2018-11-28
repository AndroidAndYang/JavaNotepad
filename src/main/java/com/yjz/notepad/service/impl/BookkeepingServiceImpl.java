package com.yjz.notepad.service.impl;

import com.yjz.notepad.bean.BookkeepingBean;
import com.yjz.notepad.bean.UserBookkeepingBean;
import com.yjz.notepad.dao.IBookkeepingDao;
import com.yjz.notepad.service.IBookkeepingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author： YJZ
 * date:  2018/11/27
 * des:  记账本
 */
@Service
public class BookkeepingServiceImpl implements IBookkeepingService {

    @Resource
    private IBookkeepingDao bookkeepingDao;

    @Override
    public Long addBookkeepingDate(BookkeepingBean bookkeepingBean) {
        return bookkeepingDao.addBookkeepingDate(bookkeepingBean);
    }

    @Override
    public List<UserBookkeepingBean> queryUserByBookkeepingType(Long userID, Long bookType, String addTime) {
        return bookkeepingDao.queryUserByBookkeepingType(userID, bookType, addTime);
    }
}
