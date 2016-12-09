package com.runmit.sweedee.datadao;

import java.util.Map;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {
	// 播放记录
    private final DaoConfig playRecordDaoConfig;
    private final PlayRecordDao playRecordDao;
    
    // 搜索本地记录
    private final DaoConfig searchHisRecordDaoConfig;
    private final SearchHisRecordDao searchHisRecordDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);
        // 播放记录部分
        playRecordDaoConfig = daoConfigMap.get(PlayRecordDao.class).clone();
        playRecordDaoConfig.initIdentityScope(type);
        playRecordDao = new PlayRecordDao(playRecordDaoConfig, this);
        
        registerDao(PlayRecord.class, playRecordDao);
        
        // 搜索部分
        searchHisRecordDaoConfig = daoConfigMap.get(SearchHisRecordDao.class).clone();
        searchHisRecordDaoConfig.initIdentityScope(type);
        searchHisRecordDao = new SearchHisRecordDao(searchHisRecordDaoConfig, this);

        registerDao(SearchHisRecord.class, searchHisRecordDao);
    }
    
    public void clear() {
        playRecordDaoConfig.getIdentityScope().clear();
        searchHisRecordDaoConfig.getIdentityScope().clear();
    }

    public PlayRecordDao getPlayRecordDao() {
        return playRecordDao;
    }
    
    public SearchHisRecordDao getSearchHisRecordDao() {
        return searchHisRecordDao;
    }

}