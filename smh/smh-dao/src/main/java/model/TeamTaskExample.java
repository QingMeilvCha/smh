package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeamTaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTeamTaskIdIsNull() {
            addCriterion("team_task_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdIsNotNull() {
            addCriterion("team_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdEqualTo(Integer value) {
            addCriterion("team_task_id =", value, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdNotEqualTo(Integer value) {
            addCriterion("team_task_id <>", value, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdGreaterThan(Integer value) {
            addCriterion("team_task_id >", value, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_task_id >=", value, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdLessThan(Integer value) {
            addCriterion("team_task_id <", value, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("team_task_id <=", value, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdIn(List<Integer> values) {
            addCriterion("team_task_id in", values, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdNotIn(List<Integer> values) {
            addCriterion("team_task_id not in", values, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("team_task_id between", value1, value2, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("team_task_id not between", value1, value2, "teamTaskId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Integer value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Integer value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Integer value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Integer value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Integer value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Integer> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Integer> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Integer value1, Integer value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Integer value1, Integer value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(Integer value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(Integer value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(Integer value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(Integer value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(Integer value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<Integer> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<Integer> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(Integer value1, Integer value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(Integer value1, Integer value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("creat_time =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("creat_time <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("creat_time >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creat_time >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("creat_time <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("creat_time <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("creat_time in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("creat_time not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("creat_time between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("creat_time not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}