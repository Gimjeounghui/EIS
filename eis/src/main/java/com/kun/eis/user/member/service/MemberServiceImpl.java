package com.kun.eis.user.member.service;

import com.kun.eis.user.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.UUID;

/**
 * 23.04.28
 * MemberServiceImpl 추가
 * (memberRegist, memberDetail ..)
 * 23.05.04
 * MemberUpdate ver2 추가
 */
	
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	/**
	 * 23.05.04
	 * uploadPath 설정 예졍
	 */
	@Value("${member.upload.path}")
	String uploadPath;

	@Override
	public List<MemberVO> MemberList(MemberVO vo) {

		return memberMapper.MemberList(vo);
	}
	@Override
	public MemberVO selectPwCode(MemberVO vo)  {
		return memberMapper.selectPwCode(vo);
	}

	@Override
	public boolean memberRegist(MemberVO vo) {
		return memberMapper.memberRegist(vo);
	}



	@Override
	public MemberVO memberDetail(String m_email) {
		return memberMapper.memberDetail(m_email);
	}

	/**
	 * 23.04.28
	 * memberUpdate ver1
	 *
	 * @Transactional
	 * @Override
	 * public boolean memberUpdate(MemberVO vo, MultipartFile m_photo){
	 * 	boolean result = memberMapper.memberUpdate(vo);
	 * 	return result;
	 * }
	 */

	/**
	 * 23.05.04
	 * memberUpdate ver2
	 * photo upload 기능 추가
	 * uploadPath 추가 예정
	 * photo imagesave 위치 및 이름 변경 예정
	 */
	@Transactional
	@Override
	public boolean memberUpdate(MemberVO vo, MultipartFile m_photo) {
		boolean result = memberMapper.memberUpdate(vo);

		String imageOrigin = m_photo.getOriginalFilename();
		String imageName = imageOrigin.substring(imageOrigin.lastIndexOf("/") + 1);
		String uuid = UUID.randomUUID().toString();
		if(imageName == null || imageName == "") {
			uuid = null;
		}
		String m_imageName = uuid + "_" + imageName;
		String imageSave = uploadPath + uuid + "_" + imageName;
		if(imageName == null || imageName == "") {
			imageSave = uploadPath + imageName;
		}


		/*

		String imageOrigin = m_photo.getOriginalFilename();
		String imageName = imageOrigin.substring(imageOrigin.lastIndexOf("/") + 1);

 		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();
		String strToday = date.format(c1.getTime());

		String m_imageName = imageName + "_" + strToday;
		String imageSave = uploadPath + imageName + "_" + strToday;

		 */


		/*
		 * 
		 * try { File saveImage= new File(imageSave); m_photo.transferTo(saveImage);
		 * 
		 * } catch (Exception e) { System.out.println("upload error 입니다."); }
		 * 
		 * if(imageName == null || imageName == "") {
		 * memberMapper.memberImageInsert(MemberUploadVO.builder().m_email(vo.getM_email
		 * ()).build()); } else {
		 * memberMapper.memberImageInsert(MemberUploadVO.builder().m_photo(m_imageName).
		 * m_photo_path(uploadPath).m_email(vo.getM_email()).build());
		 * vo.setM_photo_path(uploadPath); vo.setM_photo(m_imageName); }
		 */

		return result;
	}

	@Transactional
	@Override
	public boolean memberDelete(String m_email) {
		return memberMapper.memberDelete(m_email);
	}




}