/* by Yiyang Bu */

package review.model;

public class Categories {
	protected Integer categoryId;
	protected String title;
	protected Boolean assignable;

	public Categories(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Categories(Integer categoryId, String title, Boolean assignable) {
		this.categoryId = categoryId;
		this.title = title;
		this.assignable = assignable;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getTitle() {
		return title;
	}
	
	public Boolean getAssignable() {
		return assignable;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAssignable(Boolean assignable) {
		this.assignable = assignable;
	}

}