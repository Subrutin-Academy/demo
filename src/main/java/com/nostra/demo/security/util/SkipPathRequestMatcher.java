package com.nostra.demo.security.util;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SkipPathRequestMatcher implements RequestMatcher {

	private OrRequestMatcher skipMatcher;
	private OrRequestMatcher processingMatcher;

	public SkipPathRequestMatcher(List<String> pathsToSkip, List<String> processingPath) {

		List<RequestMatcher> m = pathsToSkip.stream().map(path -> new AntPathRequestMatcher(path))
				.collect(Collectors.toList());
		skipMatcher = new OrRequestMatcher(m);

		List<RequestMatcher> p = processingPath.stream().map(path -> new AntPathRequestMatcher(path))
				.collect(Collectors.toList());
		processingMatcher = new OrRequestMatcher(p);

	}

	@Override
	public boolean matches(HttpServletRequest request) {
		if (skipMatcher.matches(request)) {
			return false;
		}

		return processingMatcher.matches(request) ? true : false;
	}

}
