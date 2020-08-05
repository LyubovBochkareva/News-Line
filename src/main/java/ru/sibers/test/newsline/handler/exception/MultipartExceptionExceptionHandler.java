package ru.sibers.test.newsline.handler.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;

import java.text.DecimalFormat;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@ControllerAdvice
public class MultipartExceptionExceptionHandler {
	@ExceptionHandler(MultipartException.class)
	public ResponseEntity<Object> handleMultipartException(MaxUploadSizeExceededException ex) {
		String maxFileSize = getMaxUploadFileSize(ex);
		return new ResponseEntity<>("File size exceeds the allowable limit! " + maxFileSize, HttpStatus.PAYLOAD_TOO_LARGE);
	}

	/**
	 * Returns a string with an error message and the maximum allowed file size.
	 *
	 * @param ex error
	 * @return a string with an error message and the maximum allowed file size
	 */
	private String getMaxUploadFileSize(MaxUploadSizeExceededException ex) {
		String msg = ex.getMessage();
		if (msg.contains("FileSizeLimitExceededException") || msg.contains("SizeLimitExceededException")) {
			String maxFileSize = msg.substring(msg.indexOf("maximum")).replaceAll("\\D+", "");
			if (StringUtils.isNumeric(maxFileSize)) {
				return asReadableFileSize(Long.valueOf(maxFileSize));
			}
		}
		return null;
	}

	private static String asReadableFileSize(long size) {
		if (size <= 0) return "0";
		final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
		int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
		return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}
}