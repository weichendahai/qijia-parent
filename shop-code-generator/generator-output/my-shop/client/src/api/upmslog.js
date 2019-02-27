
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmslog/list',
        method: 'get'
    });
}

export function insertUpmsLog(data) {
    return fetch({
        url: '/api/upmslog/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsLog(data) {
    return fetch({
        url: '/api/upmslog/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsLog(data) {
    return fetch({
        url: '/api/upmslog/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}