package whut.mall.entity;

import java.util.List;

/**
 * mall
 * 2020/8/24 10:55
 * 分页类
 *
 * @author 李俊秋
 **/

public class PageInfo<T> {
    private List<T> list;           // 每页的数据
    private int totalPage;          // 总页数
    private int totalCount;         // 总数据量
    private int size;               // 每页的数据量
    private int currentPage;        // 当前页数

    public PageInfo() {
    }

    public PageInfo(List<T> list, int totalPage, int totalCount, int size, int currentPage) {
        this.list = list;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.size = size;
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", size=" + size +
                ", currentPage=" + currentPage +
                '}';
    }
}
