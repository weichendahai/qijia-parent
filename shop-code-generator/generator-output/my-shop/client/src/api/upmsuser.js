
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsuser/list',
        method: 'get'
    });
}

export function insertUpmsUser(data) {
    return fetch({
        url: '/api/upmsuser/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsUser(data) {
    return fetch({
        url: '/api/upmsuser/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsUser(data) {
    return fetch({
        url: '/api/upmsuser/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}