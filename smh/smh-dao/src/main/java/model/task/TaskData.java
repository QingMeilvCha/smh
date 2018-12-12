package model.task;

public class TaskData {
    private Integer taskDataId;

    private String mark;

    private String data;

    public Integer getTaskDataId() {
        return taskDataId;
    }

    public void setTaskDataId(Integer taskDataId) {
        this.taskDataId = taskDataId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}