
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmssystem/list',
        method: 'get'
    });
}

export function insertUpmsSystem(data) {
    return fetch({
        url: '/api/upmssystem/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsSystem(data) {
    return fetch({
        url: '/api/upmssystem/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsSystem(data) {
    return fetch({
        url: '/api/upmssystem/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}