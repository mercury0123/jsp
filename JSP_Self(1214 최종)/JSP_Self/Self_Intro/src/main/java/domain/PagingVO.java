package domain;

public class PagingVO {
	
	private int pageNo;	//현재 화면에 출력되는 페이지 네이션 번호
	private int qty;	//한 페이지당 보여줄 게시글의 수 (페이지당 10개,20개 출력)

	public PagingVO() {	//페이지 네이션을 클릭하기 전, 기본 리스트 출력값
		this(1, 10);	//페이지 네이션 번호1, 1페이지에 10개씩 출력
	}	
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}

	//gettersetter
	public int getPageStart() {
		return (this.pageNo-1)*qty;	//시작페이지 번호 구하기
	}		
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}