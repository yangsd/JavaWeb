package com.example.exception;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

/**
 * 异常处理类
 * @author sdyang
 * @date 2015年6月3日 上午9:19:11
 */
public class MyExceptionResolver extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		try {
			// handler business exception
			if (ex instanceof BusinessException) {
				if (isAjaxRequest(request)) {
					return handleAjaxBusinessException((Exception) ex, request,response, handler);
				} else {
					return handleBusinessException((BusinessException) ex,request, response, handler);
				}
			}
			// handler system exception
			else if (isAjaxRequest(request)) {
				return handleAjaxSystemException(ex, request, response, handler);
			} else {
				return handleSystemException(ex, request, response, handler);
			}
		} catch (Exception handlerException) {
			logger.warn("Handling of [" + ex.getClass().getName()
					+ "] resulted in Exception", handlerException);
		}
		return null;
	}

	/**
	 * 通过请求头部判断是否为ajax请求
	 * 
	 * @param request
	 *            请求体
	 * @return 真：ajax请求；假：非ajax请求
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {
		final String header = request.getHeader("x-requested-with");
		if (header != null && header.trim().equalsIgnoreCase("XMLHttpRequest")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * handler ajax business exception
	 * 
	 * @param ex
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws HttpMessageNotWritableException
	 * @throws IOException
	 */
	private ModelAndView handleAjaxBusinessException(Exception ex,
			HttpServletRequest request, HttpServletResponse response,
			Object handler) throws HttpMessageNotWritableException, IOException {
		// get input and output message
		HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(
				response);
		// get contentType
		List<MediaType> acceptedMediaTypes = inputMessage.getHeaders()
				.getAccept();
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		PrintStream pstream = new PrintStream(byteOut);
		ex.printStackTrace(pstream);
		pstream.close();

		ExceptionMessage returnValue = new ExceptionMessage(ex.getMessage(),
				new String(byteOut.toByteArray()));
		for (MediaType mediaType : acceptedMediaTypes) {
			Class<? extends ExceptionMessage> returnValueType = returnValue
					.getClass();
			if (messageConverter.canWrite(returnValueType, mediaType)) {
				messageConverter.write(returnValue, mediaType, outputMessage);
				return new ModelAndView();
			}
		}
		return null;
	}

	private ModelAndView handleAjaxSystemException(Exception ex,
			HttpServletRequest request, HttpServletResponse response,
			Object handler) throws HttpMessageNotWritableException, IOException {
		// get input and output message
		HttpInputMessage inputMessage = new ServletServerHttpRequest(request);
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(
				response);
		// get contentType
		List<MediaType> acceptedMediaTypes = inputMessage.getHeaders()
				.getAccept();
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		// printStackTrace To String
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		PrintStream pstream = new PrintStream(byteOut);
		ex.printStackTrace(pstream);
		pstream.close();

		ExceptionMessage returnValue = new ExceptionMessage(ex.getMessage(),
				new String(byteOut.toByteArray()));
		for (MediaType mediaType : acceptedMediaTypes) {
			Class<? extends ExceptionMessage> returnValueType = returnValue
					.getClass();
			if (messageConverter.canWrite(returnValueType, mediaType)) {
				messageConverter.write(returnValue, mediaType, outputMessage);
				break;
			}
		}
		// convert java object to json
		// write to responseMessage
		return new ModelAndView();
	}

	private ModelAndView handleSystemException(Exception ex,
			HttpServletRequest request, HttpServletResponse response,
			Object handler) {
		ModelAndView model = new ModelAndView("html/error/error.jsp");
		// print stackTrace to string
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		PrintStream pstream = new PrintStream(byteOut);
		ex.printStackTrace(pstream);
		pstream.close();

		ExceptionMessage exceptionMessage = new ExceptionMessage(
				ex.getMessage(), new String(byteOut.toByteArray()));
		model.addObject("exceptionMessage", exceptionMessage);
		return model;
	}

	private ModelAndView handleBusinessException(BusinessException ex,
			HttpServletRequest request, HttpServletResponse response,
			Object handler) {
		ModelAndView model = new ModelAndView("html/error/error.jsp");
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		PrintStream pstream = new PrintStream(byteOut);
		ex.printStackTrace(pstream);
		pstream.close();
		ExceptionMessage exceptionMessage = new ExceptionMessage(
				ex.getMessage(), new String(byteOut.toByteArray()));
		model.addObject("exceptionMessage", exceptionMessage);
		return model;
	}

}
