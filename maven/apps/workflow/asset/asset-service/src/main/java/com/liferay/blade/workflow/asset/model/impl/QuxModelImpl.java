/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.blade.workflow.asset.model.impl;

import com.liferay.blade.workflow.asset.model.Qux;
import com.liferay.blade.workflow.asset.model.QuxModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the Qux service. Represents a row in the &quot;Workflow_Qux&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>QuxModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuxImpl}.
 * </p>
 *
 * @author Inácio Nery
 * @see QuxImpl
 * @generated
 */
@ProviderType
public class QuxModelImpl extends BaseModelImpl<Qux> implements QuxModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a qux model instance should use the <code>Qux</code> interface instead.
	 */
	public static final String TABLE_NAME = "Workflow_Qux";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"quxId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("quxId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Workflow_Qux (uuid_ VARCHAR(75) null,quxId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table Workflow_Qux";

	public static final String ORDER_BY_JPQL = " ORDER BY qux.quxId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Workflow_Qux.quxId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long UUID_COLUMN_BITMASK = 4L;

	public static final long QUXID_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public QuxModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _quxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQuxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _quxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Qux.class;
	}

	@Override
	public String getModelClassName() {
		return Qux.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Qux, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Qux, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qux, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Qux)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Qux, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Qux, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Qux)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Qux, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Qux, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Qux, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Qux, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Qux, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Qux, Object>>();
		Map<String, BiConsumer<Qux, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Qux, ?>>();

		attributeGetterFunctions.put("uuid", Qux::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Qux, String>)Qux::setUuid);
		attributeGetterFunctions.put("quxId", Qux::getQuxId);
		attributeSetterBiConsumers.put(
			"quxId", (BiConsumer<Qux, Long>)Qux::setQuxId);
		attributeGetterFunctions.put("groupId", Qux::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Qux, Long>)Qux::setGroupId);
		attributeGetterFunctions.put("companyId", Qux::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Qux, Long>)Qux::setCompanyId);
		attributeGetterFunctions.put("userId", Qux::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Qux, Long>)Qux::setUserId);
		attributeGetterFunctions.put("userName", Qux::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Qux, String>)Qux::setUserName);
		attributeGetterFunctions.put("createDate", Qux::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Qux, Date>)Qux::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Qux::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Qux, Date>)Qux::setModifiedDate);
		attributeGetterFunctions.put("status", Qux::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Qux, Integer>)Qux::setStatus);
		attributeGetterFunctions.put("statusByUserId", Qux::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId", (BiConsumer<Qux, Long>)Qux::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Qux::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Qux, String>)Qux::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Qux::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<Qux, Date>)Qux::setStatusDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getQuxId() {
		return _quxId;
	}

	@Override
	public void setQuxId(long quxId) {
		_quxId = quxId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Qux.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Qux.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Qux toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Qux)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		QuxImpl quxImpl = new QuxImpl();

		quxImpl.setUuid(getUuid());
		quxImpl.setQuxId(getQuxId());
		quxImpl.setGroupId(getGroupId());
		quxImpl.setCompanyId(getCompanyId());
		quxImpl.setUserId(getUserId());
		quxImpl.setUserName(getUserName());
		quxImpl.setCreateDate(getCreateDate());
		quxImpl.setModifiedDate(getModifiedDate());
		quxImpl.setStatus(getStatus());
		quxImpl.setStatusByUserId(getStatusByUserId());
		quxImpl.setStatusByUserName(getStatusByUserName());
		quxImpl.setStatusDate(getStatusDate());

		quxImpl.resetOriginalValues();

		return quxImpl;
	}

	@Override
	public int compareTo(Qux qux) {
		long primaryKey = qux.getPrimaryKey();

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
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Qux)) {
			return false;
		}

		Qux qux = (Qux)obj;

		long primaryKey = qux.getPrimaryKey();

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
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		QuxModelImpl quxModelImpl = this;

		quxModelImpl._originalUuid = quxModelImpl._uuid;

		quxModelImpl._originalGroupId = quxModelImpl._groupId;

		quxModelImpl._setOriginalGroupId = false;

		quxModelImpl._originalCompanyId = quxModelImpl._companyId;

		quxModelImpl._setOriginalCompanyId = false;

		quxModelImpl._setModifiedDate = false;

		quxModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Qux> toCacheModel() {
		QuxCacheModel quxCacheModel = new QuxCacheModel();

		quxCacheModel.uuid = getUuid();

		String uuid = quxCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			quxCacheModel.uuid = null;
		}

		quxCacheModel.quxId = getQuxId();

		quxCacheModel.groupId = getGroupId();

		quxCacheModel.companyId = getCompanyId();

		quxCacheModel.userId = getUserId();

		quxCacheModel.userName = getUserName();

		String userName = quxCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			quxCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			quxCacheModel.createDate = createDate.getTime();
		}
		else {
			quxCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			quxCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			quxCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		quxCacheModel.status = getStatus();

		quxCacheModel.statusByUserId = getStatusByUserId();

		quxCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = quxCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			quxCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			quxCacheModel.statusDate = statusDate.getTime();
		}
		else {
			quxCacheModel.statusDate = Long.MIN_VALUE;
		}

		return quxCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Qux, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Qux, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qux, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Qux)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Qux, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Qux, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Qux, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Qux)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Qux.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Qux.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _quxId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private Qux _escapedModel;

}