
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsuserorganization/list',
        method: 'get'
    });
}

export function insertUpmsUserOrganization(data) {
    return fetch({
        url: '/api/upmsuserorganization/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsUserOrganization(data) {
    return fetch({
        url: '/api/upmsuserorganization/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsUserOrganization(data) {
    return fetch({
        url: '/api/upmsuserorganization/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}