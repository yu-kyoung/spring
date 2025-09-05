package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Paging;



@Controller
public class BoardController {
//  @Autowired BoardMapper boardMapper;
   @Autowired BoardService boardService;
  // boardList데이터를 꺼낼 때 사용할 이름
  @GetMapping("/boardList")
  public String boardList(Model model,BoardVO boardVO,Paging paging) {
		//페이징관련
		paging.setPageUnit(5);//페이징건수
		paging.setTotalRecord(boardService.selectCount(boardVO));
		boardVO.setFirst(paging.getFirst());
		boardVO.setLast(paging.getLast());
	    model.addAttribute("boardList",boardService.selectBoardList(boardVO));
        return "board/boardList";
  }
  //단건조회
  @GetMapping("/board")
  public String board(Model model,@RequestParam Long bno) {
	  System.out.println(">>> bno=" + bno);
	  model.addAttribute("board",boardService.selectBno(bno));
	  return "board/board";
  }
  //삭제
	@PostMapping("/delBoard")
	public String delBoard(@RequestParam Long bno) {
		return "redirect:/boardList";
	}
	
	//등록 페이지로 이동
	@GetMapping("/board/register")
	public String boardpage(BoardVO boardVO) {
		return "/board/register";
			}
	
	
	@Value("${file.upload.dir}")
	String UPLOAD_DIR;
	
	//등록처리
	@PostMapping("/board/register")
	public String boardRegister(BoardVO boardVO, MultipartFile file) throws IllegalStateException, IOException {
		if(! file.isEmpty() && file.getSize() >0) {
			//첨부파일 업로드
			file.transferTo(new File(UPLOAD_DIR, file.getOriginalFilename()));
			//파일명을 DB에 저장
			boardVO.setAttach(file.getOriginalFilename());
		}
		boardService.insertBoard(boardVO);
		return "redirect:/boardList";
	}
	
	
	@GetMapping("/filedown/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws MalformedURLException {
		// 파일 경로 설정
		Path filePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();

		// 파일을 Resource 로 로드
		Resource resource = new UrlResource(filePath.toUri());
		if (!resource.exists()) {
			return ResponseEntity.notFound().build();
		}

		// Content-Disposition 헤더에 다운로드용 파일명 지정
		String contentDisposition = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM) // 이진 파일
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}
	
}
