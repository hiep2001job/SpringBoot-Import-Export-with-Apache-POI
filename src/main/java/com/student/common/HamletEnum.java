package com.student.common;

public enum HamletEnum {
	AP_MOI("Ấp Mới"),
	PHUON_AN_1("Phương An 1"),
	PHUONG_AN_2("Phương An 2"),
	PHUONG_AN_3("Phương An 3"),
	PHUONG_BINH_1("Phương Bình 1"),
	PHUONG_BINH_2("Phương Bình 2"),
	PHUONG_HOA_1("Phương Hòa 1"),
	PHUONG_HOA_2("Phương Hòa 2"),
	PHUONG_HOA_3("Phương Hòa 3"),
	PHUONG_THANH_1("Phương Thạnh 1"),
	PHUONG_THANH_2("Phương Thạnh 2");

	private final String text;

	/**
	 * @param text
	 */
	HamletEnum(final String text) {
		this.text = text;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return text;
	}
}
