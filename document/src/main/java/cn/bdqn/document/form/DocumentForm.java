package cn.bdqn.document.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import cn.bdqn.document.entity.Document;

public class DocumentForm extends Document{

	private MultipartFile upload;
	
	@NotBlank
	@Override
	public String getTitle() {	
		return super.getTitle();
	}
	
	@NotBlank
	@Override
	public String getNote() {		
		return super.getNote();
	}
	
	@NotNull
	public MultipartFile getUpload() {
		return upload==null||upload.isEmpty()?null:upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
}
