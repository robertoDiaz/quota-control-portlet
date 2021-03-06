/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.lsug.quota.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.lsug.quota.model.Quota;
import org.lsug.quota.model.QuotaModel;
import org.lsug.quota.model.QuotaSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Quota service. Represents a row in the &quot;LSUGQUOTA_Quota&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.lsug.quota.model.QuotaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuotaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotaImpl
 * @see org.lsug.quota.model.Quota
 * @see org.lsug.quota.model.QuotaModel
 * @generated
 */
@JSON(strict = true)
public class QuotaModelImpl extends BaseModelImpl<Quota> implements QuotaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a quota model instance should use the {@link org.lsug.quota.model.Quota} interface instead.
	 */
	public static final String TABLE_NAME = "LSUGQUOTA_Quota";
	public static final Object[][] TABLE_COLUMNS = {
			{ "quotaId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "quotaAssigned", Types.BIGINT },
			{ "quotaUsed", Types.BIGINT },
			{ "quotaStatus", Types.INTEGER },
			{ "quotaAlert", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table LSUGQUOTA_Quota (quotaId LONG not null primary key,classNameId LONG,classPK LONG,quotaAssigned LONG,quotaUsed LONG,quotaStatus INTEGER,quotaAlert INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LSUGQUOTA_Quota";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.lsug.quota.model.Quota"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.lsug.quota.model.Quota"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.lsug.quota.model.Quota"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Quota toModel(QuotaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Quota model = new QuotaImpl();

		model.setQuotaId(soapModel.getQuotaId());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setQuotaAssigned(soapModel.getQuotaAssigned());
		model.setQuotaUsed(soapModel.getQuotaUsed());
		model.setQuotaStatus(soapModel.getQuotaStatus());
		model.setQuotaAlert(soapModel.getQuotaAlert());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Quota> toModels(QuotaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Quota> models = new ArrayList<Quota>(soapModels.length);

		for (QuotaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.lsug.quota.model.Quota"));

	public QuotaModelImpl() {
	}

	public long getPrimaryKey() {
		return _quotaId;
	}

	public void setPrimaryKey(long primaryKey) {
		setQuotaId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_quotaId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Quota.class;
	}

	public String getModelClassName() {
		return Quota.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("quotaId", getQuotaId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("quotaAssigned", getQuotaAssigned());
		attributes.put("quotaUsed", getQuotaUsed());
		attributes.put("quotaStatus", getQuotaStatus());
		attributes.put("quotaAlert", getQuotaAlert());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long quotaId = (Long)attributes.get("quotaId");

		if (quotaId != null) {
			setQuotaId(quotaId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long quotaAssigned = (Long)attributes.get("quotaAssigned");

		if (quotaAssigned != null) {
			setQuotaAssigned(quotaAssigned);
		}

		Long quotaUsed = (Long)attributes.get("quotaUsed");

		if (quotaUsed != null) {
			setQuotaUsed(quotaUsed);
		}

		Integer quotaStatus = (Integer)attributes.get("quotaStatus");

		if (quotaStatus != null) {
			setQuotaStatus(quotaStatus);
		}

		Integer quotaAlert = (Integer)attributes.get("quotaAlert");

		if (quotaAlert != null) {
			setQuotaAlert(quotaAlert);
		}
	}

	@JSON
	public long getQuotaId() {
		return _quotaId;
	}

	public void setQuotaId(long quotaId) {
		_quotaId = quotaId;
	}

	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	public long getQuotaAssigned() {
		return _quotaAssigned;
	}

	public void setQuotaAssigned(long quotaAssigned) {
		_quotaAssigned = quotaAssigned;
	}

	@JSON
	public long getQuotaUsed() {
		return _quotaUsed;
	}

	public void setQuotaUsed(long quotaUsed) {
		_quotaUsed = quotaUsed;
	}

	@JSON
	public int getQuotaStatus() {
		return _quotaStatus;
	}

	public void setQuotaStatus(int quotaStatus) {
		_quotaStatus = quotaStatus;
	}

	@JSON
	public int getQuotaAlert() {
		return _quotaAlert;
	}

	public void setQuotaAlert(int quotaAlert) {
		_quotaAlert = quotaAlert;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Quota.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Quota toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Quota)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		QuotaImpl quotaImpl = new QuotaImpl();

		quotaImpl.setQuotaId(getQuotaId());
		quotaImpl.setClassNameId(getClassNameId());
		quotaImpl.setClassPK(getClassPK());
		quotaImpl.setQuotaAssigned(getQuotaAssigned());
		quotaImpl.setQuotaUsed(getQuotaUsed());
		quotaImpl.setQuotaStatus(getQuotaStatus());
		quotaImpl.setQuotaAlert(getQuotaAlert());

		quotaImpl.resetOriginalValues();

		return quotaImpl;
	}

	public int compareTo(Quota quota) {
		long primaryKey = quota.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		Quota quota = null;

		try {
			quota = (Quota)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = quota.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		QuotaModelImpl quotaModelImpl = this;

		quotaModelImpl._originalClassNameId = quotaModelImpl._classNameId;

		quotaModelImpl._setOriginalClassNameId = false;

		quotaModelImpl._originalClassPK = quotaModelImpl._classPK;

		quotaModelImpl._setOriginalClassPK = false;

		quotaModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Quota> toCacheModel() {
		QuotaCacheModel quotaCacheModel = new QuotaCacheModel();

		quotaCacheModel.quotaId = getQuotaId();

		quotaCacheModel.classNameId = getClassNameId();

		quotaCacheModel.classPK = getClassPK();

		quotaCacheModel.quotaAssigned = getQuotaAssigned();

		quotaCacheModel.quotaUsed = getQuotaUsed();

		quotaCacheModel.quotaStatus = getQuotaStatus();

		quotaCacheModel.quotaAlert = getQuotaAlert();

		return quotaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{quotaId=");
		sb.append(getQuotaId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", quotaAssigned=");
		sb.append(getQuotaAssigned());
		sb.append(", quotaUsed=");
		sb.append(getQuotaUsed());
		sb.append(", quotaStatus=");
		sb.append(getQuotaStatus());
		sb.append(", quotaAlert=");
		sb.append(getQuotaAlert());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.lsug.quota.model.Quota");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>quotaId</column-name><column-value><![CDATA[");
		sb.append(getQuotaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quotaAssigned</column-name><column-value><![CDATA[");
		sb.append(getQuotaAssigned());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quotaUsed</column-name><column-value><![CDATA[");
		sb.append(getQuotaUsed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quotaStatus</column-name><column-value><![CDATA[");
		sb.append(getQuotaStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quotaAlert</column-name><column-value><![CDATA[");
		sb.append(getQuotaAlert());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Quota.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Quota.class
		};
	private long _quotaId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _quotaAssigned;
	private long _quotaUsed;
	private int _quotaStatus;
	private int _quotaAlert;
	private long _columnBitmask;
	private Quota _escapedModelProxy;
}