package com.account.module.service;

import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.account.module.dao.RegisterDAO;
import com.account.module.dao.RegisterDAOImpl;
import com.account.module.dto.LoginDTO;
import com.account.module.dto.RegisterDTO;
import com.account.module.dto.ResetDTO;
import com.account.module.dto.UpdateDTO;
import com.account.module.exceptions.RepositoryException;
import com.account.module.exceptions.ServiceException;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDAO dao;
	@Autowired
	private SendEmail sendEmail;
	@Autowired
	private SendEmailForOTP emailForOTP;
	static Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	public RegisterServiceImpl() {

		logger.info("invoked service method");
	}

	@Override
	public String validateAndSave(RegisterDTO dto) throws ServiceException {
		boolean valid = false;
		String message = "NA";
		logger.info("invoked validateAndSave method in serviceImpl");
		try {
			if (Objects.nonNull(dto)) {
				String firstName = dto.getFirstName();
				String lastName = dto.getLastName();
				String email = dto.getEmail();

				if (!StringUtils.isEmpty(firstName) || firstName.length() > 3) {
					logger.debug("FirstName is valid");
					valid = true;
				} else {
					logger.debug("FirstName is invalid");
					valid = false;
				}
				if (valid) {
					if (!StringUtils.isEmpty(lastName)) {
						logger.debug("LastName is valid");
						valid = true;
					} else {
						logger.debug("LastName is invalid");
						valid = false;
					}
				}
				if (valid) {
					if (!StringUtils.isEmpty(email)) {
						String regExp = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
								+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

						boolean result = email.matches(regExp);

						logger.debug("Email is valid");
						valid = true;
					} else {
						logger.debug("Email is invalid");
						valid = false;
					}
				}
				if (valid) {
					String pwd = dto.getPassword();
					if (pwd.length() >= 4) {
						logger.debug("Password is valid");
						valid = true;

					} else {
						logger.debug("Password is invalid");
						valid = false;
					}
				}
				if (valid) {
					String password = dto.getPassword();
					String cnfPassword = dto.getConfirmPassword();
					if (password.equals(cnfPassword)) {
						logger.debug("ConfirmPassword is matching with password");
						valid = true;

					} else {
						logger.debug("ConfirmPassword is not matching with password");
						valid = false;
					}
				}

				if (valid) {
					if (dao.fetchEmailCount(dto) > 1) {
						message = "DUPLICATE";
						logger.debug("Email id is already exist");
					} else {

						boolean sentMail = sendEmail.sendMail(dto);
						if (sentMail) {
							long pk = dao.save(dto);
							message = "SAVED";
							logger.debug("Data is valid data saved to DB");
							logger.debug("Data is saved to DB with id=" + pk);
						} else {
							logger.debug("Email not sent, Data not saved");
						}
					}

				} else {
					logger.debug("Data is invalid it can't be saved to DB");
				}
			}
		} catch (RepositoryException e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		} catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return message;
	}

	@Override
	public List<RegisterDTO> loginDetails(String email) throws ServiceException {
		List<RegisterDTO> regDTO = null;
		try {
			regDTO = dao.fetchDetailsforLogin(email);
		} catch (RepositoryException e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		} catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return regDTO;
	}

	@Override
	public String validateAndLogin(RegisterDTO dto, LoginDTO loginDTO) throws ServiceException {
		String message = "NA";
		List<RegisterDTO> registerDTO = null;
		int successCount;
		boolean accountStatus;
		long failedCount = 0;

		logger.info("invoked validateAndLogin() in serviceImpl");
		try {
			if (Objects.nonNull(dto)) {
				registerDTO = dao.fetchDetailsforLogin(loginDTO.getEmail());
				for (RegisterDTO registerDTO1 : registerDTO) {
					accountStatus = registerDTO1.isStatus();
					logger.info("Account lock status " + accountStatus);
					if (accountStatus == false) {
						if (registerDTO.size() == 1) {

							if (registerDTO1.getPassword().equals(loginDTO.getPassword())) {
								message = "SUCCESS";
								logger.debug("Login successfully");
								successCount = dao.updateLoginFailedCount(loginDTO.getEmail(), 0);
								logger.debug("count reset to " + successCount);
							} else {
								failedCount = registerDTO1.getFailCount();
								// failedCount++;
								logger.debug("Error message..... " + failedCount);
								if (failedCount < 3) {
									dao.updateLoginFailedCount(loginDTO.getEmail(), ++failedCount);
									logger.debug("Error message..... " + failedCount);
									message = "FAIL";
									logger.debug("Password mismatching, Login Failed");
								} else {
									accountStatus = dao.updateLoginaccountStatus(loginDTO.getEmail(), true);
									message = "Maximum wrong attempts";
									logger.debug(
											accountStatus + " user reached maximum wrong attempts, account is blocked");
								}
								logger.debug(registerDTO1);
							}
						} else {
							message = "not Registered";
							logger.debug(" Login Failed,Please register with us before logging");
						}
					}
					if (accountStatus == true) {
						logger.info("Account Locked");
						message = "locked";
					}
				}
			}
		} catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return message;
	}

	@Override
	public String validateAndResetPassword(RegisterDTO dto) throws ServiceException {
		String tempPasswords = null;
		String message = "NA";
		boolean temp = false;
		logger.debug("invoked validateAndResetPassword() ");
		try {
			long passwordCount = dao.fetchEmailCount(dto);
			logger.debug(passwordCount);
			if (passwordCount == 1) {
				tempPasswords = dao.updateNewPassword(dto);
				List<RegisterDTO> list = dao.fetchDetailsforLogin(dto.getEmail());
				for (RegisterDTO registerDTO : list) {
					temp = emailForOTP.onSendOTP(registerDTO, tempPasswords);
					dao.updateLoginFailedCount(registerDTO.getEmail(), 0);// resetting
																			// count
																			// to
																			// 0
																			// for
																			// forgot
																			// password
																			// option
					dao.updateLoginaccountStatus(registerDTO.getEmail(), false); // &
																					// status
																					// to
																					// false
																					// so
																					// that
																					// by
																					// resetting
																					// pswd
																					// user
																					// can
																					// again
																					// login

					temp = true;

					// logger.debug(tempPasswords);
					// temp = emailForOTP.onSendOTP(dto, tempPasswords);
					if (temp) {
						message = "SUCCESS";
						logger.debug("OTP email Sent");
						return message;
					} else {
						message = "Fail";
						logger.debug("OTP email not Sent");
						return message;
					}
				}
			} else {
				logger.debug("Passwords are mismatching update failed");
			}
		} catch (RepositoryException e) {
			throw new ServiceException("Exception in service " + e.getMessage());

		} catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return message;
	}

	@Override
	public String validateAndUpdateNewPassword(ResetDTO resetDTO) throws ServiceException {
		String message = "NA";
		String tempPassword = resetDTO.getTempPassword();
		String newPassword = resetDTO.getNewPassword();
		String cnfPassword = resetDTO.getConfirmPassword();
		boolean vaild = false;
		logger.debug("invoked validateAndUpdateNewPassword() ");

		try {
			if (Objects.nonNull(resetDTO)) {
				if (!StringUtils.isEmpty(tempPassword) && (!StringUtils.isEmpty(newPassword))
						&& (!StringUtils.isEmpty(cnfPassword))) {
					vaild = true;
				}
				if (vaild) {
					if (resetDTO.getNewPassword().equals(resetDTO.getConfirmPassword())) {
						boolean validTempPassword = dao.fetchPasswordCountForUpdate(resetDTO);
						logger.debug(validTempPassword);
						if (validTempPassword) {
							newPassword = dao.updateNewPassword(resetDTO);
							logger.debug(resetDTO.getNewPassword());
							message = "SUCCESS";
							logger.debug("updated new password by replacing OTP");
							return message;

						} else {
							message = "Invalid_tempPassword";
							logger.debug("TempPassword is invalid");
							return message;
						}
					} else {
						message = "Mismatch";
						logger.debug("newPassword & ConfirmPassword are not matching");
					}

				} else {
					message = "NewPassword updateFail";
					logger.debug("OTP is not matching,Not updated new password");
					return message;
				}

			}
		} catch (RepositoryException e) {
			throw new ServiceException("Exception in service " + e.getMessage());

		} catch (Exception e) {
			throw new ServiceException("Exception in service " + e.getMessage());
		}
		return message;
	}

	@Override
	public String updateDetails(RegisterDTO dto, UpdateDTO udto) throws ServiceException {
		String message = "NA";
		List<RegisterDTO> registerDTO = null;
		logger.debug("invoked update details() ");
		try {
			if (Objects.nonNull(udto)) {
				registerDTO = dao.fetchDetailsforLogin(dto.getEmail());
				for (RegisterDTO registerDTO2 : registerDTO) {

					if (!registerDTO2.getFirstName().equals(udto.getFirstName())
							|| !registerDTO2.getLastName().equals(udto.getLastName())) {

						dao.updateNames(udto);
						message = "UPDATED";
						logger.debug("details changed & saved");
						return message;
					} else {
						message = "NOT UPDATED";
						logger.debug("details are not changed & saved");
						return message;
					}
				}
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return message;
	}

	/*
	 * @Override public RegisterDTO getUserByEmail(String email) {
	 * 
	 * return dao.getUserByEmail(email); }
	 */

}
