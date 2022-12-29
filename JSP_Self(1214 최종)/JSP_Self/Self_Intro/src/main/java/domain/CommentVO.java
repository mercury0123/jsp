package domain;

//댓글은 detail.jsp에 뿌려줘야함
public class CommentVO {
	
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String reg_at;
	
	//기본생성자
	public CommentVO(){}	
		
	//post(bno 어느 게시글에 대한 댓글인가 , writer, content)
	public CommentVO(int bno, String writer, String content) {
		this.bno=bno;
		this.writer=writer;
		this.content=content;
	}
	
	//list(bno, cno, writer, content, reg_at)
	public CommentVO(int bno,int cno, String writer, String content,String reg_at) {
		this.bno=bno;
		this.cno=cno;
		this.writer=writer;
		this.content=content;
		this.reg_at=reg_at;
	}
	//modify(cno 수정할 댓글번호, content)
	public CommentVO(int cno, String content) {
		this.cno=cno;		
		this.content=content;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg_at() {
		return reg_at;
	}

	public void setReg_at(String reg_at) {
		this.reg_at = reg_at;
	}
	
}
