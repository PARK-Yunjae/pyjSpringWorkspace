package kr.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

// @Controller --> 리턴을 뷰리졸버로 넘김
@RequestMapping("/api")
@RestController // 리턴값을 @ResponseBody 넘겨줌
public class BoardController {
	@Autowired
	BoardMapper boardMapper;

	@GetMapping("/boards")
	public List<Board> boardList(){
		List<Board> list = boardMapper.getLists();
		return list;
	}
	
	@PostMapping("/boards") // 바디가 있어야 한다?
	public String addBoard(@RequestBody Board board) {
		System.out.println("글쓰기 들어ㅗㅇㅁ?");
		String msg = board.toString();
		int result = boardMapper.boardInsert(board);
		
		return result == 1 ? "게시글 추가 완료" : "게시글 추가 실패" + msg;
	}
	
	@GetMapping("/boards/{idx}")
	public Board getOneBoard(@PathVariable int idx){
		boardMapper.boardCount(idx);
		Board vo = boardMapper.boardContent(idx);
		return vo;
	}
	
	@DeleteMapping("/boards/{idx}")
	public String deleteOneBoard(@PathVariable int idx) {
		int result = boardMapper.boardDelete(idx);
		return result == 1 ? "게시글 삭제 완료" : "게시글 삭제 실패";
	}
	
	@PutMapping("/boards/{idx}") // 바디가 있어야 한다?
	public String updateBoard(@RequestBody Board board) {
		String msg = board.toString();
		int result = boardMapper.boardUpdate(board);
		
		return result == 1 ? "게시글 수정 완료" : "게시글 수정 실패" + msg;
	}
}
