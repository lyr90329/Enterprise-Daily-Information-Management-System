package com.lyr.util;

public class PageUtil {
	public static Page createPage(int everyPage, int totalCount, int currentPage) {
		everyPage = getEveryPage(everyPage);  //每页最大显示记录数
		int totalPage = getTotalPage(everyPage, totalCount);  //总页数
		currentPage = getCurrentPage(currentPage);   //当前页
		int beginIndex = getBeginIndex(everyPage, currentPage);//开始索引
		boolean hasPrePage = getHasPrePage(currentPage);//是否有上一页
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);//是否有下一页
		Page page = new Page(everyPage, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage, hasNextPage);
		return page;
	}

	public static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 10 : everyPage;
	}

	public static int getTotalPage(int everyPage, int totalCount) {
		int totalPage = 0;
		if (totalCount != 0 && totalCount % everyPage == 0) {
			totalPage = totalCount / everyPage;
		} else {
			totalPage = totalCount / everyPage + 1;
		}
		return totalPage;
	}

	public static int getCurrentPage(int currentPage) {
		return currentPage;
	}

	public static int getBeginIndex(int everyPage, int currentPage) {
		return (currentPage - 1) * everyPage;
	}

	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage ? false : true;
	}
}
