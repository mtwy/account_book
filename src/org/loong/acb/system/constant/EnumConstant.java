package org.loong.acb.system.constant;

public class EnumConstant {

	// 登录级别
	public static final String LOGIN_LEVEL_NORMAL = "normal"; // 普通账户登录
	public static final String LOGIN_LEVEL_ADMIN = "admin"; // 管理员登录
	
	// 用户等级
	public static final String USER_LEVEL_MASTER = "master"; // 主账户
	public static final String USER_LEVEL_SECONDARY = "secondary"; // 从属帐号
	
	// 账单类型
	public static final String BILL_TYPE_INCOME = "01.income"; // 入账
	public static final String BILL_TYPE_DEFRAY = "02.defray"; // 出账
	public static final String BILL_TYPE_FLAT = "01.flat"; // 平账
	
	// 类别类型
	public static final String CATEGORY_TYPE_BILL = "01.bill_category"; // 账单类别
	public static final String CATEGORY_TYPE_LEDGER = "02.ledger_category"; // 分账类别
	
}
