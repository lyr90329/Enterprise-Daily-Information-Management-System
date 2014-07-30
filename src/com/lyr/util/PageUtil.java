package com.lyr.util;

public class PageUtil {
	public static Page createPage(int everyPage, int totalCount, int currentPage) {
		everyPage = getEveryPage(everyPage);  //ÿҳ�����ʾ��¼��
		int totalPage = getTotalPage(everyPage, totalCount);  //��ҳ��
		currentPage = getCurrentPage(currentPage);   //��ǰҳ
		int beginIndex = getBeginIndex(everyPage, currentPage);//��ʼ����
		boolean hasPrePage = getHasPrePage(currentPage);//�Ƿ�����һҳ
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);//�Ƿ�����һҳ
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
