package com.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.condition.UserQueryCondition;
import com.example.dao.UserDao;
import com.example.exception.BusinessException;
import com.example.itf.UserService;
import com.example.util.ExcelUtils;
import com.example.vo.ExcelFileInfoVO;
import com.example.vo.UserVO;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;

	public String addUser(UserVO user) throws BusinessException {

		if (userDao.getUserByLoginId(user.getLoginid()) != null) {
			throw new BusinessException("该用户" + user.getLoginid() + "已经存在！");
		}
		int result = userDao.addUser(user);
		if (result <= 0) {
			throw new BusinessException("failure to insert a new user !");
		} else {
			// 新增用户成功则返回用户主键
			return getUserByLoginId(user.getLoginid()).getPk_user() + "";
		}
	}

	public Boolean deleteUser(UserVO pk_user) throws BusinessException {
		int result = userDao.deleteUser(pk_user);

		if (result <= 0) {
			throw new BusinessException("failure to delete user !");
		} else {
			return true;
		}
	}

	public String updateUser(UserVO user) throws BusinessException {
		int result = userDao.updateUser(user);

		if (result <= 0) {
			throw new BusinessException("failure to update user !");
		} else {
			// 修改成功则返回用户主键
			return user.getPk_user() + "";
		}
	}

	public UserVO getUserById(int id) throws BusinessException {
		return userDao.getUserById(id);
	}

	public UserVO getUserByLoginId(String loginId) throws BusinessException {
		return userDao.getUserByLoginId(loginId);
	}

	public List<UserVO> getAllUser() throws BusinessException {
		return userDao.getAllUser();
	}

	public int getUserCount(UserQueryCondition params) throws BusinessException {
		return userDao.getUserCount(params);
	}

	public List<UserVO> getUsers(UserQueryCondition params)
			throws BusinessException {
		return userDao.getUsers(params);
	}

	public void downLoadFile(HttpServletResponse response)
			throws BusinessException {

		String fileName = "workbook.xls";

		List<UserVO> userList = userDao.getAllUser();
		ExcelFileInfoVO excel = new ExcelFileInfoVO();
		List<String> excelHead = new ArrayList<String>();

		List<List> result = new ArrayList<List>();

		excelHead.add("column1");
		excelHead.add("column2");
		excelHead.add("column3");
		excelHead.add("column4");
		excelHead.add("column5");

		for (UserVO vo : userList) {
			List user = new ArrayList();
			user.add(vo.getPk_user());
			user.add(vo.getLoginid());

			user.add(vo.getName());

			user.add(vo.getAccess());
			user.add(vo.getCreatime());
			result.add(user);
		}

		excel.setExcelTitle("Title");
		excel.setColumnCount(4);
		excel.setExcelBody(result);
		excel.setExcelHead(excelHead);

		ExcelUtils util = new ExcelUtils();
		HSSFWorkbook wb = util.writeData(excel);

		response.setHeader("Content-Disposition", "inline; filename="
				+ fileName);
		// 确保发送的当前文本格式
		response.setContentType("application/vnd.ms-excel");

		try {
			ServletOutputStream outputStream = response.getOutputStream();

			wb.write(outputStream);

			// 清除缓存
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String upLoadFile(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {
		MultipartHttpServletRequest mulRequest = (MultipartHttpServletRequest) request;  
        MultipartFile file = mulRequest.getFile("excel");  
        String filename = file.getOriginalFilename();  
        if (filename == null || "".equals(filename))  
        {  
            return null;  
        }  
        try  
        {  
            InputStream input = file.getInputStream();  
            HSSFWorkbook workBook = new HSSFWorkbook(input);  
            HSSFSheet sheet = workBook.getSheetAt(0);  
            if (sheet != null)  
            {  
                for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++)  
                {  
                    HSSFRow row = sheet.getRow(i);  
                    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++)  
                    {  
                        HSSFCell cell = row.getCell(j);  
                        String cellStr = cell.toString();  
                        System.out.print("【"+cellStr+"】 ");  
                    }  
                    System.out.println();  
                }  
  
            }  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        return "";
	}

}
