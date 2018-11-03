package com.ks.jabosystems.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 请假表
 * 
 * @author yuanyuhui
 *
 */
public class Leave {
	/**
	 * 对应一个请假表,对应多个审核表
	 */
	// `leave_id` INT(30) DEFAULT NULL COMMENT '请假ID',
	// `create_time` DATETIME DEFAULT NULL COMMENT '请假发起时间',
	// `end_time` DATETIME DEFAULT NULL COMMENT '请假结束时间',
	// `leave_day` INT(30) DEFAULT NULL COMMENT '请假天数',
	// `create_eid` VARCHAR(20) DEFAULT NULL COMMENT '请假的人员ID',
	// `next_eid` VARCHAR(20) DEFAULT NULL COMMENT '待处理人员ID',
	// `event` VARCHAR(200) DEFAULT NULL COMMENT '事由说明'
	private Integer leave_id;
	private Date create_time;
	private Date end_time;
	private Integer leave_day;
	private String create_eid;
	private String next_eid;
	private String event;

	private List<Checkresult> list_Checkresult = new ArrayList<Checkresult>(0);

	public Integer getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Integer getLeave_day() {
		return leave_day;
	}

	public void setLeave_day(Integer leave_day) {
		this.leave_day = leave_day;
	}

	public String getCreate_eid() {
		return create_eid;
	}

	public void setCreate_eid(String create_eid) {
		this.create_eid = create_eid;
	}

	public String getNext_eid() {
		return next_eid;
	}

	public void setNext_eid(String next_eid) {
		this.next_eid = next_eid;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public List<Checkresult> getList_Checkresult() {
		return list_Checkresult;
	}

	public void setList_Checkresult(List<Checkresult> list_Checkresult) {
		this.list_Checkresult = list_Checkresult;
	}

	public Leave(Integer leave_id, Date create_time, Date end_time, Integer leave_day, String create_eid,
			String next_eid, String event, List<Checkresult> list_Checkresult) {
		super();
		this.leave_id = leave_id;
		this.create_time = create_time;
		this.end_time = end_time;
		this.leave_day = leave_day;
		this.create_eid = create_eid;
		this.next_eid = next_eid;
		this.event = event;
		this.list_Checkresult = list_Checkresult;
	}

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Leave [leave_id=" + leave_id + ", create_time=" + create_time + ", end_time=" + end_time
				+ ", leave_day=" + leave_day + ", create_eid=" + create_eid + ", next_eid=" + next_eid + ", event="
				+ event + ", list_Checkresult=" + list_Checkresult + "]";
	}

}
