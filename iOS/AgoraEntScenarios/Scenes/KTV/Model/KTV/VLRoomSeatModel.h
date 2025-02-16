//
//  VLRoomSetModel.h
//  VoiceOnLine
//

#import "VLBaseModel.h"


NS_ASSUME_NONNULL_BEGIN

@interface VLRoomSeatModel : VLBaseModel
///是否是房主
@property (nonatomic, assign) BOOL isMaster;
///头像
@property (nonatomic, copy) NSString *headUrl;
///userNO
@property (nonatomic, copy) NSString *userNo;
@property (nonatomic, copy) NSString *id;
///昵称
@property (nonatomic, copy) NSString *name;
///在哪个座位
@property (nonatomic, assign) NSInteger onSeat;
///是否合唱
@property (nonatomic, assign) BOOL joinSing;
///是否自己静音
@property (nonatomic, assign) NSInteger isSelfMuted;
///是否开启视频
@property (nonatomic, assign) NSInteger isVideoMuted;

///新增, 判断当前歌曲是否是自己点的
@property (nonatomic, assign) BOOL ifSelTheSingSong;

@property (nonatomic, assign) BOOL ifJoinedChorus;



/// for sync manager
@property (nonatomic, copy, nullable) NSString* objectId;

/// 重置下麦模型
- (void)resetLeaveSeat;

@end

NS_ASSUME_NONNULL_END
