package domain;

public class BoardVO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String reg_date;
	private int read_count;
	private String image_file;
	
	//생성자 : 기본생성자	
	public BoardVO() {}
	
	//insert
	public BoardVO(String title,String writer,String content) {		
		this.title=title;
		this.writer=writer;
		this.content=content;
	}
	
	//list
	public BoardVO(int bno,String title,String writer,String reg_date,int read_count) {
		this.bno=bno;		
		this.title=title;
		this.writer=writer;
		this.reg_date=reg_date;
		this.read_count=read_count;
	}
		
	//detail(all)
	public BoardVO(int bno,String title,String writer, String content,
			String reg_date,int read_count, String image_file) {
		this.bno=bno;		
		this.title=title;
		this.writer=writer;
		this.content=content;
		this.reg_date=reg_date;
		this.read_count=read_count;		
		this.image_file=image_file;
	}
	
	//update	
		public BoardVO(int bno,String title,String content) {
			this.bno=bno;		
			this.title=title;			
			this.content=content;
		}

	//gettersetter
	
	public int getBno() {
		return bno;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	
	
}
